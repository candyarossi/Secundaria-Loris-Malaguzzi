--[[
    PONG - TP Final: Lenguaje Lua & Love2d - 6to año - Instituto Loris Malaguzzi
    Traducción: Candela Yarossi
    candyarossi@gmail.com

    -- PONG 0 - Momento 0 --

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

WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 720

--[[
    love.load() Se ejecuta cuando el juego se inicia por primera vez, solo una vez; 
    utilizado para inicializar el juego
]]
function love.load()
    love.window.setMode(WINDOW_WIDTH, WINDOW_HEIGHT, {
        fullscreen = false,
        resizable = false,
        vsync = true            -- VSync o Vertical Sync, que en castellano sería 
                                -- "sincronización vertical", es una tecnología gráfica 
                                -- diseñada para los videojuegos. Lo que hace esta 
                                -- tecnología detectar cuáles son los fotogramas por segundo 
                                -- (FPS) a los que se está moviendo el juego y la tasa de 
                                -- refresco de tu monitor, y los sincroniza para evitar 
                                -- problemas como el "screen tearing".
    })
end

--[[
    love.draw() Llamado después de la actualización/refresco (update) por LÖVE2D, se usa 
    para dibujar cualquier cosa en la pantalla, actualizado o no
]]
function love.draw()
    love.graphics.printf(
        'Hello Pong!',          -- Texto a renderizar
        0,                      -- Inicio de X (0 ya que lo vamos a centrar en función del ancho)
        WINDOW_HEIGHT / 2 - 6,  -- Inicio de Y (a la mitad de la pantalla) (6px aprox. de tamaño de fuente)
        WINDOW_WIDTH,           -- Número de píxeles para centrar el texto dentro (toda la pantalla aquí)
        'center')               -- Modo de alineación, puede ser 'center', 'left', o 'right'
end
