--[[
    PONG - TP Final: Lenguaje Lua & Love2d - 6to año - Instituto Loris Malaguzzi
    Traducción: Candela Yarossi
    candyarossi@gmail.com

    Fuente Original: GD50 2020 - Pong remake
    Autor: Colton Ogden
    cogden@cs50.harvard.edu 


    -- Clase 'Paddle' --

    Representa una paleta que se puede mover hacia arriba y hacia abajo. 
    Usada en el programa principal para desviar la pelota hacia el oponente
]]

Paddle = Class{}

--[[
    La función 'init' en nuestra clase se llama solo una vez, cuando el objeto
    se crea. Se usa para configurar todas las variables en la clase y obtenerlas
    listas para usar.

    Nuestra paleta debe llevar una X y una Y, para el posicionamiento en el plano,
    así como un ancho y altura para sus dimensiones.

    Tenga en cuenta que la palabra "self" es una referencia a *este* objeto, cualquiera 
    sea el objeto instanciado en el momento en que se llama a esta función. Diferentes 
    objetos pueden tener sus propios valores de x, y, ancho y alto, por lo que estas 
    variables sirven como contenedores para los datos. En este sentido, son muy similares
    a las estructuras en C.
]]
function Paddle:init(x, y, width, height)
    self.x = x
    self.y = y
    self.width = width
    self.height = height
    self.dy = 0
end

function Paddle:update(dt)
    -- math.max aquí asegura de que estamos posicionados por sobre el 0 del 
    -- eje Y o que la posición actual del jugador calculada de Y al presionar 
    -- hacia arriba no quede en negativo; el cálculo del movimiento es simplemente
    -- nuestra velocidad de paleta previamente definida multiplicada por dt
    if self.dy < 0 then
        self.y = math.max(0, self.y + self.dy * dt)

    -- Similar a antes, esta vez usamos math.min para asegurarnos de no
    -- ir más lejos que la parte inferior de la pantalla menos la altura 
    -- de la paleta (o de lo contrario irá parcialmente por debajo, ya que 
    -- la posición está basada en su esquina superior izquierda
    else
        self.y = math.min(VIRTUAL_HEIGHT - self.height, self.y + self.dy * dt)
    end
end

--[[
    Para ser llamado por nuestra función principal en el main con 'love.draw'. 
    Usamos la función 'rectangle' de LÖVE2D, que toma un modo de dibujo como el 
    primer argumento, así como la posición y las dimensiones del rectángulo. Para
    cambiar el color, uno debe llamar 'love.graphics.setColor'. A partir de la
    versión más reciente de LÖVE2D, ¡incluso puedes dibujar rectángulos redondeados!
]]
function Paddle:render()
    love.graphics.setColor(255, 0, 255, 255)
    love.graphics.rectangle('fill', self.x, self.y, self.width, self.height)
end