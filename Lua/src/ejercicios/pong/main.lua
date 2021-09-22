-- INICIOS CON LOVE

-- Lua, para repasar, es un lenguaje de programación multiparadigma, imperativo, estructurado
-- y bastante ligero, que fue diseñado como un lenguaje interpretado con una semántica extendible.
-- El nombre signica «luna» en portugués.
-- Debido a que Lua compilado es pequeño (en la mayoría de los casos), veloz y tiene una licencia 
-- permisiva ha ganado seguidores entre los desarrolladores de videojuegos. El motor gráco de 
-- Crytek, CryEngine, está programado en Lua, además de en C++. Empresas como VALVe, EA Games 
-- y Bethesda decidieron trasladar sus bases de C++ a Lua dado que este es más compatible 
-- gráficamente con el kernel.
-- Lua se implementa como una biblioteca, escrita en C limpio, el subconjunto común de 
-- Standard C y C++. 

-- Página oficial: https://www.lua.org
-- Documentación versión 5.4.3: https://www.lua.org/manual/5.4/ 


-- LÖVE2D es un motor de juegos multiplataforma de código abierto para desarrollar videojuegos 2D.
-- El motor está escrito en C++ y utiliza Lua como lenguaje de programación. Está publicado bajo 
-- la licencia zlib.

-- Página oficial: https://love2d.org
-- Documentación: https://love2d.org/wiki/Main_Page


-- Primeros pasos en Love
-- Dibujando texto
function love.draw()
    love.graphics.print("Hola Mundo!", 400, 300)
end

-- Dibujando una imagen
function love.load()
    image = love.graphics.newImage("/pong-final/ico.png")
end
function love.draw()
    love.graphics.draw(image, 300, 200)
end

-- Reproduciendo un sonido
function love.load()
    sound = love.audio.newSource("/pong-final/sounds/paddle_hit.wav", "stream")
    love.audio.play(sound)
end