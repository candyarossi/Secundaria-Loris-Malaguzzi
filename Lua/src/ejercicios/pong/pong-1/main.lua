--[[
    PONG - TP Final: Lenguaje Lua & Love2d - 6to año - Instituto Loris Malaguzzi
    Traducción: Candela Yarossi
    candyarossi@gmail.com

    -- PONG 1 - La Actualización de Baja Resolución --

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

-- push es una biblioteca que nos permitirá renderizar nuestro juego en 
-- una resolución virtual, en lugar de lo grande que sea nuestra ventana; 
-- utilizado para proporcionar una estética más retro
--
-- https://github.com/Ulydev/push
push = require 'push'

WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

VIRTUAL_WIDTH = 432
VIRTUAL_HEIGHT = 243

--[[
    Se ejecuta cuando el juego se inicia por primera vez, solo una vez; 
    utilizado para inicializar el juego
]]
function love.load()
    -- Utilizamos el filtro nearest-neighbor ("vecino más cercano") al 
    -- aumentar y reducir la escala para evitar que el texto y los gráficos 
    -- se vean borrosos; comenten esta función para ver la diferencia
    love.graphics.setDefaultFilter('nearest', 'nearest')

    -- Inicializamos nuestra resolución virtual, que será renderizada dentro de nuestra 
    -- ventana actual sin importar sus dimensiones; reemplaza nuestra llamada 
    -- love.window.setMode de la entrega anterior
    push:setupScreen(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        resizable = false,
        vsync = true
    })
end

--[[
    Keyboard handling (Manejo del teclado), llamado por LÖVE2D en cada cuadro (frame)*;
    pasa por parámetro la tecla que presionamos para que podamos acceder a alguna 
    función o acción en específico
]]
function love.keypressed(key)
    -- Las teclas son accesibles mediante su nombre
    if key == 'escape' then
        -- Esta función permite finalizar la aplicación
        love.event.quit()
    end
end

--[[
    love.draw() Llamado después de la actualización/refresco (update) por LÖVE2D, se usa 
    para dibujar cualquier cosa en la pantalla, actualizado o no
]]
function love.draw()
    -- Comienzo del render de la resolución virtual
    push:apply('start')

    -- El mismo printf de la entrega anterior pero en una sola línea
    -- Ahora estamos usando ancho y alto virtuales para la colocación del texto
    love.graphics.printf('Hello Pong!', 0, VIRTUAL_HEIGHT / 2 - 6, VIRTUAL_WIDTH, 'center')

    -- Fin del render de la resolución virtual
    push:apply('end')
end

-- *FPS: Explicación en Youtube: https://youtu.be/7lUFluLOh-s