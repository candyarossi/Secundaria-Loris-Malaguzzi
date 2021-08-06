--[[local contador = 0

while contador ~= 4 do
    print("While", contador)
    contador = contador + 1 
end

print("\n")

local contador2 = 0 

repeat
    print("Repeat", contador2)
    contador2 = contador2 + 1 
until contador2 == 4

print("\n")

for i = 1, 4, 1 do
    print("For", i)
end

print("\n")]]