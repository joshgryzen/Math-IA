curve = [25,1,1,1,1,1]
#f = open("joshua.txt", "a")
big = [] 
prob = []
sort = []
mx = 0
biggest = 0
counter = 0
index = 0

def add(key):
    curve[key] += 1
    if curve[key] == 26: 
        curve[key] = 1
        add(key + 1)

def factorial(n):
    fact = 1
    i = 1
    while i <= n:
        fact *= i
        i += 1
    return fact

def combination(n, r):
    num = factorial(n)
    den = factorial(r)*factorial(n-r)
    return (num/den)

# K i the number of cards of a certain cost
# k is the number of K cards drawn
# N is the population size
# n is the number of draws

def hyperGeo(K, k, N, n):
    return (combination(K, k)*combination(N-K, n-k))/combination(N, n)

#print(1- hyperGeo(2, 0, 30, 4))

def create():
    stng = str(curve[0]) + "," + str(curve[1]) + "," + str(curve[2]) + "," + str(curve[3]) + "," + str(curve[4]) + "," + str(curve[5])
    big.append(stng) 
    i = 0
    temp = 0
    while i < 6:
        temp += (1- hyperGeo(curve[i], 0, 30, 4+i))
        i+=1
    prob.append(temp)

    #if temp>mx:
    #    mx = temp
    #print(mx)
    
    #f.write(stng + "\n")

while curve[5] != 25: 
    add(0)
    if curve[0] + curve[1] + curve[2] + curve[3] + curve[4] + curve[5] == 30:
        create()
print("done")
#print(big)

for i in prob:
    if i > biggest:
        print("Mana Distribution: " + big[counter] + " Sum of Probabilities: " + str(i))
        biggest = i
        index = counter
    counter+= 1


