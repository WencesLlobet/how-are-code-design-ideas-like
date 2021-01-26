## Code design concepts

## Code design is how readable is code 

Readable code is faster to reason about. It is also more matainable and allows faster onboarding and entrustment of tasks.

Regardless of the technical implications code is (as written language) subdivided, it is modularized into packages.

Kinds of packages (modules):
- 📦 - Class/File
- 📦 - Function
- 📦 - Package/Folder
- 📦 - Service/Project
- 📦 - Line of code
- 📦 - ...

This packages communicate to each other, they may hide some information to their outside users (data), they can also hide some implementation details (logic). 

##  Coupling is when packages comunicate more than necesary.
#### If packages comunicate more than necesary they can be re-factored into a better design.

- 📦🧶📦 - too coupled Classes/Files
- 📦🧶📦 - too coupled Functions 
- 📦🧶📦 - too coupled Packages
- 📦🧶📦 - too coupled Services/Projects
- 📦🧶📦 - ...

Excess of comunication can be:
- Directions of comunication (both packages telling and asking eachother)
- To much comunication points (endpoints, public methods...)
- Too much data in each comunication (passing a whole user details to know if it is from Europe)

### Types of Coupling
```
Message coupling (unavoidable)"
    🏠.💡.turnOn()  

Data Coupling (unavoidable):
    🏠.🎚.dim(253)   

Stamp/Structure Coupling:
    createAndEmailGiftVoucher({22,💲,adress,🎨}) 
    ⇩              
    email(📦.giftVoucher())  

Control Coupling:
    🏗️.up() 🏗️.left() 🏗️.down()
    ⇩   
    👷.use(🏗️) ... 👷.build(“wall”) 

External Coupling:
    🚞.🏢.scheduleCsv() ... 🚝.🏢.scheduleCsv()
    ⇩                                               
    🚞.🏣.canRunToday() ... 🚝.🏬.endingHour()            

Commmon Coupling: 
    🚂.🏢.schedule().setFault() ... 🚝.🏢.schedule().incidents() 
    ⇩         
    🚂.🏣.notifyFault() ... 🚝.🏬.canRun() 

Content Coupling:
    👷.🏗️.engine.startEngine() 
         ⤷  🏗️.👷.hasTiedSecurityBelt()
                 ⤷  👷.🏗.setCredentials(🔑)
    ⇩   
    👷 has 🏗️
    🏗️ has not 👷
    🏗️.engine is private -> 🏗️.start()
```

## Cohesion
A package that has its all inner parts working together is called cohesive.
Adding code/data to a package may alter its cohesion.
### Class cohesion (according to attributes)
```
Mixed-Role
    Same domain language, little related
        PizzaToppings.class
            ╠═ 🧀
            ╠═ 🍅
          X ╚═ 🌾  wheat

Mixed-Domain
    Same process, different tech. layer
        PoliceReport.class 
            ╠═ 🛂 pasport check status
            ╠═ 🛃 luggage check status 
          X ╚═ 🔌 port number 8080

Mixed-Instance
    Different responsability
        ServingModality.class
          X ╠═ 🧀
            ╠═ 🛵 (courier number)
            ╠═ 🪑 (table number)
          X ╚═ 🍅
```