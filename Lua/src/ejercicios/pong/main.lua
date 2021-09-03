--[[
    PONG - TP Final: Lenguaje Lua & Love2d - 6to año - Instituto Loris Malaguzzi
    Traducción: Candela Yarossi
    candyarossi@gmail.com

    Fuente Original: GD50 2020 - Pong remake
    Autor: Colton Ogden
    cogden@cs50.harvard.edu 


    -- Programa principal --

    Programado originalmente por Atari en 1972. Cuenta con dos
    paletas, controladas por dos jugadores, con el objetivo de conseguir
    llevar la pelota más allá del límite de su oponente. El primero en 
    conseguir 10 puntos gana

    Esta versión está diseñada para parecerse más a la NES que a
    las máquinas Pong originales o el Atari 2600 en términos de
    resolución, aunque en pantalla ancha (16:9), por lo que se ve 
    mejor en sistemas modernos
]]


--[[ 
    "push" es una biblioteca que nos permitirá dibujar nuestro juego en una resolución 
    virtual, en lugar de lo grande que sea nuestra ventana; utilizado para proporcionar
    una estética más retro
]]

-- Fuente: https://github.com/Ulydev/push
push = require 'push'


--[[ 
    La biblioteca "Class" que estamos usando nos permitirá representar cualquier cosa en
    nuestro juego como códigos de clase/objeto, en lugar de realizar un seguimiento de 
    muchas variables dispares y métodos, podemos agruparlos y encapsularlos. (Programación
    Orientada a Objetos)
]]

-- Fuente: https://github.com/vrld/hump/blob/master/class.lua
Class = require 'class'


-- Nuestra clase paleta (Paddle), que almacena la posición y las dimensiones 
-- de cada paleta y la lógica para renderizarlas
require 'Paddle'


-- Nuestra clase pelota (Ball), que no es muy diferente a la estructura de una paleta
-- pero sí funcionará mecánicamente de forma muy diferente
require 'Ball'


-- Tamaño de nuestra ventana actual
WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

-- El tamaño que intentamos emular con PUSH
VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

-- Velocidad de movimiento de las paletas
PADDLE_SPEED = 200

--[[
    love.load(): Función llamada solo una vez al comienzo del juego; utilizada para 
    configurar objetos del juego, variables, etc. y preparar el "mundo" del juego
]]
function love.load()

    -- Establece el filtro predeterminado de Love2D en "nearest" (el más cercano), 
    -- que esencialmente significa que no habrá filtrado de píxeles (difuminación del 
    -- pixelado), que es importante para un aspecto 2D retro, agradable y nítido 
    love.graphics.setDefaultFilter('nearest', 'nearest')

    -- Configura el título de la ventana que contiene a la aplicación
    love.window.setTitle('Pong')

    -- Siembra el RNG para que las llamadas al azar sean siempre aleatorias
    -- *RNG: Generador de número aleatorio
    math.randomseed(os.time())

    -- Inicializa nuestras bonitas fuentes de texto retro
    smallFont = love.graphics.newFont('fonts/font.ttf', 8)
    largeFont = love.graphics.newFont('fonts/font.ttf', 16)
    scoreFont = love.graphics.newFont('fonts/font.ttf', 32)
    love.graphics.setFont(smallFont)

    -- Configura nuestros efectos de sonido; más tarde podemos indexar esta tabla y
    -- llamar al método "play" en cada entrada
    sounds = {
        ['paddle_hit'] = love.audio.newSource('sounds/paddle_hit.wav', 'static'),
        ['score'] = love.audio.newSource('sounds/score.wav', 'static'),
        ['wall_hit'] = love.audio.newSource('sounds/wall_hit.wav', 'static')
    }
    
    -- Inicializa nuestra resolución virtual, que será renderizada dentro de nuestra
    -- ventana real sin importar sus dimensiones
    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        resizable = true,
        vsync = true,
        canvas = false
    })

    -- Inicializa nuestras paletas para cada jugador; hacerlas globales sirve para 
    -- que puedan ser detectadas por otras funciones y módulos
    player1 = Paddle(10, 30, 5, 20)
    player2 = Paddle(VIRTUAL_WIDTH - 10, VIRTUAL_HEIGHT - 30, 5, 20)

    -- Coloca la pelota en el medio de la pantalla
    ball = Ball(VIRTUAL_WIDTH / 2 - 2, VIRTUAL_HEIGHT / 2 - 2, 4, 4)

    -- Inicializa las variables que guardan los puntajes 
    player1Score = 0
    player2Score = 0

    -- Almacena el número de jugador que comenzará a golpear la pelota
    -- Va a ser 1 o 2; quien haya anotado comienza el siguiente turno
    servingPlayer = 1

    -- Número de jugador que ganó el juego; no se establece en un valor determinado 
    -- hasta que alcancemos ese estado en el juego
    winningPlayer = 0

    -- El estado de nuestro juego puede ser cualquiera de los siguientes:
    -- 1. 'start' (el comienzo del juego, antes del primer saque)
    -- 2. 'serve' (esperando a que se presione una tecla para sacar la pelota)
    -- 3. 'play' (la pelota está en juego, rebotando entre paletas)
    -- 4. 'done' (el juego ha terminado, con un vencedor, listo para reiniciar)
    gameState = 'start'
end


--[[
    love.resize(): Función llamada cada vez que cambiamos las dimensiones de nuestra 
    ventana, como arrastrando su esquina inferior, por ejemplo. En este caso, solo 
    debemos preocuparnos sobre llamar a "push" para manejar el cambio de tamaño. 
    Toma una variable 'w' y una 'y' que representan el ancho y el alto, respectivamente
]]
function love.resize(w, h)
    push:resize(w, h)
end


--[[
    love.update(dt): Se llama a cada fotograma, pasando 'dt' desde el último fotograma.
    'dt' es la abreviatura de 'deltaTime' y se mide en segundos. Multiplicar esto por 
    cualquier cambio que deseemos hacer permitirá a nuestro juego funcionar de manera 
    consistente en todo el hardware; de lo contrario, cualquiera de los cambios que 
    hagamos se aplicarán lo más rápido posible y variarán en el hardware del sistema

    *Delta Time: es el tiempo transcurrido desde el último frame, o usando otras palabras,
    es el tiempo entre cada frame renderizado
]]
function love.update(dt)
    if gameState == 'serve' then
        -- Antes de cambiar el estado a 'play', inicializa la velocidad de la 
        -- pelota según el jugador que marcó un punto por última vez
        ball.dy = math.random(-50, 50)
        if servingPlayer == 1 then
            ball.dx = math.random(140, 200)
        else
            ball.dx = -math.random(140, 200)
        end
    elseif gameState == 'play' then
        -- Detecta la colisión de la pelota con las paletas, invirtiendo dx si es cierto
        -- y lo aumenta ligeramente, luego altera el dy según la posición en la que chocó, 
        -- y por último reproduce un efecto de sonido
        if ball:collides(player1) then
            ball.dx = -ball.dx * 1.03
            ball.x = player1.x + 5

            -- Mantiene la velocidad en la misma dirección, pero de forma aleatoria
            if ball.dy < 0 then
                ball.dy = -math.random(10, 150)
            else
                ball.dy = math.random(10, 150)
            end

            sounds['paddle_hit']:play()
        end
        if ball:collides(player2) then
            ball.dx = -ball.dx * 1.03
            ball.x = player2.x - 4

            -- Mantiene la velocidad en la misma dirección, pero de forma aleatoria
            if ball.dy < 0 then
                ball.dy = -math.random(10, 150)
            else
                ball.dy = math.random(10, 150)
            end

            sounds['paddle_hit']:play()
        end

        -- Detecta la colisión de los límites de la pantalla superior e inferior, 
        -- reproduciendo un sonido. Convertimos dy en su opuesto
        if ball.y <= 0 then
            ball.y = 0
            ball.dy = -ball.dy
            sounds['wall_hit']:play()
        end

        -- Usamos -4 para tener en cuenta el tamaño de la pelota
        if ball.y >= VIRTUAL_HEIGHT - 4 then
            ball.y = VIRTUAL_HEIGHT - 4
            ball.dy = -ball.dy
            sounds['wall_hit']:play()
        end

        -- Si llegamos al borde izquierdo o derecho de la pantalla, volvemos a sacar
        -- y actualizamos la puntuación y el jugador que saca
        if ball.x < 0 then
            servingPlayer = 1
            player2Score = player2Score + 1
            sounds['score']:play()

            -- Si llegamos a una puntuación de 10, el juego termina y se selecciona el
            -- estado 'done' para que podamos mostrar el mensaje de victoria
            if player2Score == 10 then
                winningPlayer = 2
                gameState = 'done'
            else
                gameState = 'serve'
                -- Coloca la pelota en el medio de la pantalla, sin velocidad
                ball:reset()
            end
        end

        if ball.x > VIRTUAL_WIDTH then
            servingPlayer = 2
            player1Score = player1Score + 1
            sounds['score']:play()

            if player1Score == 10 then
                winningPlayer = 1
                gameState = 'done'
            else
                gameState = 'serve'
                ball:reset()
            end
        end
    end

    -- Las paletas pueden moverse sin importar en qué estado de juego estemos
    --
    -- Jugador 1
    if love.keyboard.isDown('w') then
        player1.dy = -PADDLE_SPEED
    elseif love.keyboard.isDown('s') then
        player1.dy = PADDLE_SPEED
    else
        player1.dy = 0
    end

    -- Jugador 2
    if love.keyboard.isDown('up') then
        player2.dy = -PADDLE_SPEED
    elseif love.keyboard.isDown('down') then
        player2.dy = PADDLE_SPEED
    else
        player2.dy = 0
    end

    -- Actualiza nuestra pelota en función de su DX y DY solo si estamos en 
    -- estado de juego 'play'; escalamos la velocidad en dt para que el movimiento 
    -- sea independiente de la velocidad de los fotogramas
    if gameState == 'play' then
        ball:update(dt)
    end

    player1:update(dt)
    player2:update(dt)
end

--[[
    Creamos un callback que procesa las pulsaciones de teclas a medida que ocurren, 
    solo una vez. No tiene en cuenta las teclas que se mantienen presionadas, que son 
    manejadas por un función separada ('love.keyboard.isDown'). Útil para cuando queramos
    que ciertas cosas sucedan de inmediato, solo una vez, como cuando queremos salir
    del juego
]]
function love.keypressed(key)
    -- 'key' será cualquier tecla que este callback haya detectado como presionada
    if key == 'escape' then
        -- La función que usa LÖVE2D para salir de una aplicación
        love.event.quit()
    -- Si presionamos 'enter' durante la fase de inicio o de servicio, deberá
    -- transformarse 'gameState' al siguiente estado apropiado
    elseif key == 'enter' or key == 'return' then
        if gameState == 'start' then
            gameState = 'serve'
        elseif gameState == 'serve' then
            gameState = 'play'
        elseif gameState == 'done' then
            -- El juego está simplemente en una fase de reinicio aquí, pero establecerá 
            -- el saque para el jugador que ha perdido la partida
            gameState = 'serve'

            ball:reset()

            -- Resetea los puntajes a 0
            player1Score = 0
            player2Score = 0

            -- Decide darle el saque al jugador que ha perdido
            if winningPlayer == 1 then
                servingPlayer = 2
            else
                servingPlayer = 1
            end
        end
    end
end

--[[
    Llamado en cada fotograma después de la actualización; es responsable simplemente 
    de dibujar todos los objetos de nuestro juego y más en la pantalla.
]]
function love.draw()
    -- Empieza a dibujar con push, en nuestra resolución virtual
    push:start()

    love.graphics.clear(0, 0, 0, 0)
    
    -- Renderiza cosas diferentes dependiendo de la parte del juego en la que estemos
    if gameState == 'start' then
        -- mensajes UI 
        love.graphics.setFont(smallFont)
        love.graphics.setColor(255, 255, 0, 255)
        love.graphics.printf('Welcome to Pong!', 0, 10, VIRTUAL_WIDTH, 'center')
        love.graphics.printf('Press Enter to begin!', 0, 20, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'serve' then
        -- mensajes UI 
        love.graphics.setFont(smallFont)
        love.graphics.setColor(255, 255, 0, 255)
        love.graphics.printf('Player ' .. tostring(servingPlayer) .. "'s serve!", 
            0, 10, VIRTUAL_WIDTH, 'center')
        love.graphics.printf('Press Enter to serve!', 0, 20, VIRTUAL_WIDTH, 'center')
    elseif gameState == 'play' then
        -- mensajes UI que NO se muestran mientras se está jugando
    elseif gameState == 'done' then
        -- mensajes UI 
        love.graphics.setFont(largeFont)
        love.graphics.setColor(255, 255, 0, 255)
        love.graphics.printf('Player ' .. tostring(winningPlayer) .. ' wins!',
            0, 10, VIRTUAL_WIDTH, 'center')
        love.graphics.setFont(smallFont)
        love.graphics.printf('Press Enter to restart!', 0, 30, VIRTUAL_WIDTH, 'center')
    end

    -- Muestra la puntuación antes de que se renderice la bola para que pueda moverse
    -- sobre el texto
    displayScore()
    
    player1:render()
    player2:render()
    ball:render()

    -- Muestra FPS para depuración; simplemente se puede comentar para eliminar
    displayFPS()

    -- Termina nuestro dibujo con push
    push:finish()
end

--[[
    Función para renderizar los puntajes
]]
function displayScore()
    -- Display de puntajes
    love.graphics.setFont(scoreFont)
    love.graphics.setColor(255, 255, 255, 255)
    love.graphics.print(tostring(player1Score), VIRTUAL_WIDTH / 2 - 50,
        VIRTUAL_HEIGHT / 3)
    love.graphics.print(tostring(player2Score), VIRTUAL_WIDTH / 2 + 30,
        VIRTUAL_HEIGHT / 3)
end

--[[
    Renderiza los FPS actuales
]]
function displayFPS()
    love.graphics.setFont(smallFont)
    love.graphics.setColor(0, 255, 0, 255)
    love.graphics.print('FPS: ' .. tostring(love.timer.getFPS()), 10, 10)
    love.graphics.setColor(255, 255, 255, 255)
end
