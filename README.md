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

##  Coupling: If packages comunicate more than necesary they can be re-factored into a better design.

- 📦🧶📦 - too coupled Classes/Files
- 📦🧶📦 - too coupled Functions 
- 📦🧶📦 - too coupled Packages
- 📦🧶📦 - too coupled Services/Projects
- 📦🧶📦 - ...


### Types of Coupling
```
Message coupling (unavoidable)"
    💡.turnOn()  

Data Coupling (unavoidable):
    🎚.dim(253)   

Stamp Coupling:
    createAndEmailGiftVoucher({22,💲,adress,🎨}) 
    ⇩              
    email(📦.giftVoucher())  

Control Coupling:
    🏗️.up() 🏗️.left()  🏗️.down()
    ⇩   
    👷.use(🏗️)  ... 👷.build(“wall”) 

External Coupling:
    🚞.🏢.scheduleCsv() ... 🚝.🏢.scheduleCsv()
    ⇩                                               
    🚞.🏣.canRunToday() ... 🚝.🏬.endingHour()            

Commmon Coupling: 
    🚞.🏢.schedule().setFault() ... 🚝.🏢.schedule().incidents() 
    ⇩         
    🚞.🏣.notifyFault() ... 🚝.🏬.canRun() 

Content Coupling:
        👷.🏗️.startEngine() 
          ?⤷  🏗️.👷.hasTiedSecurityBelt()
                 ?⤷  👷.🏗.setCredentials(🔑)
```

## Cohesion
A package that has its all inner parts working together is called cohesive.
Adding code to a package shall alter its cohesion.