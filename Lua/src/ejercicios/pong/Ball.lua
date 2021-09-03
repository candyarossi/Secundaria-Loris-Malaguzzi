--[[
    PONG - TP Final: Lenguaje Lua & Love2d - 6to año - Instituto Loris Malaguzzi
    Traducción: Candela Yarossi
    candyarossi@gmail.com

    Fuente Original: GD50 2020 - Pong remake
    Autor: Colton Ogden
    cogden@cs50.harvard.edu 


    -- Clase 'Ball' --

    Representa una pelota que rebotará hacia adelante y hacia atrás entre las paletas
    y paredes hasta que pase un límite izquierdo o derecho de la pantalla, anotando
    un punto para el oponente
]]

Ball = Class{}

function Ball:init(x, y, width, height)
    self.x = x
    self.y = y
    self.width = width
    self.height = height

    -- Estas variables sirven para realizar un seguimiento de la velocidad de la pelota 
    -- tanto en el eje X como en el eje Y, ya que la bola se puede mover en dos dimensiones
    self.dy = 0
    self.dx = 0
end

--[[
    Espera una paleta como argumento y devuelve verdadero o falso, según
    si sus rectángulos (superficies de la paleta y la pelota) se superponen.
]]
function Ball:collides(paddle)
    -- Primero, verifica si el borde izquierdo de cualquiera de ellos está más a la 
    -- derecha que el borde derecho del otro
    if self.x > paddle.x + paddle.width or paddle.x > self.x + self.width then
        return false
    end

    -- Luego verifica si el borde inferior de cualquiera es más alto que el borde
    -- superior del otro
    if self.y > paddle.y + paddle.height or paddle.y > self.y + self.height then
        return false
    end 

    -- Si lo anterior no es cierto, se superponen
    return true
end

--[[
    Coloca la pelota en el medio de la pantalla, sin movimiento
]]
function Ball:reset()
    self.x = VIRTUAL_WIDTH / 2 - 2
    self.y = VIRTUAL_HEIGHT / 2 - 2
    self.dx = 0
    self.dy = 0
end

function Ball:update(dt)
    self.x = self.x + self.dx * dt
    self.y = self.y + self.dy * dt
end

function Ball:render()
    love.graphics.setColor(0, 255, 0, 255)
    love.graphics.rectangle('fill', self.x, self.y, self.width, self.height)
end