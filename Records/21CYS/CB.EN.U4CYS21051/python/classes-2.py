class Individual:
    def __init__(self, character_name, happy = True):
        self.character_name = character_name
        self.happy = happy
        
    def get_character_name(self):
        return self.character_name
        
    def is_happy(self):
        return self.happy
    
    def switchmod(self):
        if(self.happy == True ):
            self.happy = False
    
    def speak(self):
        if(self.happy) == True:
            print("Hello i am " + self.character_name)
        else:
            print("Go away!")
    
individual1 = Individual("buster",False)
individual2 = Individual("tobias")
individual3 = Individual("tin")

individual1.switchmod()   
#individual2.switchmod()

individual1.speak()
individual2.speak()
