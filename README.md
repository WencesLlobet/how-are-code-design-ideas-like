## Code design concepts

## Code design is how readable is code 

Readable code is faster to reason about. It is also more maintainable and allows faster onboarding and entrustment of tasks.

Regardless of the technical factors code is like written language: it has to be subdivided (lines, paragraphs, chapters...) we say that code is modularized into packages.

Kinds of packages (modules):
- 📦 - Class/File
- 📦 - Function
- 📦 - Package/Folder
- 📦 - Service/Project
- 📦 - Line of code
- 📦 - ...

These packages communicate with each other, they may hide some information to their outside users (data), they can also hide some implementation details (behaviour/logic). 

##  Coupling is when packages communicate more than necessary.
#### If packages communicate more than necessary they can be re-factored into a better design.

Because coupling affects any kind of package we could find coupling problem in 

- 📦🧶📦 - too coupled Classes/Files
- 📦🧶📦 - too coupled Functions 
- 📦🧶📦 - too coupled Packages
- 📦🧶📦 - too coupled Services/Projects
- 📦🧶📦 - ...

Excess of communication can be:
- Too many communication points (endpoints, public methods...)
- Too much data in each communication (passing whole user details to know if it is from Europe)
- Directions of communication (both packages telling and asking each other)

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
         ⤷  🏗️.👷.hasTiedSecurityBelt()
                 ⤷  👷.🏗.setCredentials(🔑)
    ⇩   
    👷 has 🏗️
    🏗️ has not 👷
    🏗️.engine is private -> 🏗️.start()
```

## Cohesion
A package that has its inner parts working together is called cohesive.
Adding code/data to a package may alter its cohesion.
### Class cohesion (according to attributes/data)
```
Mixed-Role
    Same domain language, little related
        PizzaToppings.class
            ╠═ 🧀
            ╠═ 🍅
         !! ╚═ 🌾  wheat

Mixed-Domain
    Same process, different tech. layer
        PoliceReport.class 
            ╠═ 🛂 pasport check status
            ╠═ 🛃 luggage check status 
         !! ╚═ 🌐  “/reports-v2/{id}”

Mixed-Instance
    Different responsability
        ServingModality.class
         !! ╠═ 🧀
            ╠═ 🛵 (courier number)
            ╠═ 🪑 (table number)
         !! ╚═ 🍅
```
### Class cohesion (according to functions/behaviour)
```
Logical (I/O)
    Each is an unrelated execution flow
    The flow gets selected with the same triggering variable (event, selector...)
        Incomming events
            ╠═ f1("payment approval": Event) ✔️ -> 📢
            ╠═ f2("payment request": Event) 🎫 -> 🏦  
         !! ╠═ serviceHealth() 🧰 -> 🟢                          
            ╚═ f3("save user cc. details": Event) 💳  -> 👤

Temporal - TBD
        WeeklyTasks 
            ╠═ calculateWeekHighscore() 📒 -> 🏅
            ╠═ removeOldUsersFromDb()  👥 -> 👤                
         !! ╚═ signInUser()  👤 -> 📒


Procedural
        PurchaseSequence
            ╠═ validateUser() 👤 ->  🟢 
            ╠═ processPayment()  💲 -> 📒            
         !! ╠═ renderDailyOffersBanners()  📦 -> 🏳️                  
            ╚═ sendPurchaseOrdersToSupplier() 🎫 -> 🚚

Communicational
    Ones input of the other
        Folder
            ╠═ f() 💲 -> 📒 (ledger checks)
            ╠═ f() 💲 -> 🕵️ (anti checks)
         !! ╚═ f() 📦 -> 🚚 (assign delivery)

Sequential
    Ones input of the other
        Folder
            ╠═ f() 🐄 -> 🥩
            ╠═ f() 🥩 -> 🍔
         !! ╠═ f() 🌾 -> 🍚
            ╚═ f() 🍔 -> 🍽️
```
