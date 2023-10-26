import random
# Front end
    # Log in
        # Certain many tries
        # hint
    # Create a profile
    # Create account
    # View categories

# Back end
    # must use text file as database

# Class types
    # User
        # List of accounts associated with it
    # Account

# uname,INFORMATION,pwd,first name,last name
# uname,ACCOUNT,

def checkRow(row):
    row_list = row.rstrip().split(",")
    if len(row_list) > 1:
        if row_list[1] == "INFORMATION":
            return "USER"
        elif row_list[1] == "ACCOUNT":
            return "ACCOUNT"
        else:
            print('Database error')
            return False


class Account:
    pass


class User:
    def __init__(self, uname, pwd, fname, lname, account_list=[]):
        self.username = uname
        self.password = pwd
        self.first_name = fname
        self.last_name = lname
        self.account_list = account_list
    
    def add_account(self, account_object):
        self.account_list.append(account_object)

   


class Database:
    def __init__(self):
        self.update_database()

    def update_database(self):
        with open("database.txt" , "r") as file:
            self.db = file.readlines()

    def write_database(self):
        with open("database.txt" , "w") as file:
            file.writelines(self.db)
    
    
    def get_user_creds(self, row):
        row_list = row.rstrip().split(",")
        uname = row_list[0]
        pwd = row_list[2]

        return uname, pwd


    def get_account_row(self):
        pass

    def check_user(self, uname, pwd):
        # return the user object
        # or
        # return a message that says failed
        for line in self.db:
            if checkRow(line) == "USER":
                check_uname, check_pwd = self.get_user_creds(line)
                if uname == check_uname and pwd == check_pwd:
                    line_list = line.rstrip().split(",")
                    return User(line_list[0], line_list[2], line_list[3], line_list[4])
        
        return -1


    def add_row(self, text):
        with open("database.txt", "a") as file:
            file.write(text)
        return
    
    def add_user(self, uname, pwd, fname, lname):
        self.add_row(text=uname+",INFORMATION,"+pwd+","+fname+","+lname+"\n")
        self.update_database()

    def add_account(self,uname,name,accountuname,pwd,category):
        self.add_row(f"{uname},ACCOUNT,{name},{accountuname},{pwd},{category}\n")
        self.update_database()

    def viewaccounts(self,uname,category):
        for line in self.db:
            if checkRow(line) == "ACCOUNT":
                line_list = line.rstrip().split(",")
                if line_list[-1] == category and line_list[0] == uname:
                    print(f'Account name: {line_list[2]}')
                    print(f'User name: {line_list[3]}')
                    print(f'Password: {line_list[4]}\n')

    def edit_account(self,uname,name,accountuname,pwd,category):
        for i in range(len(self.db)):
            if checkRow(self.db[i]) == "ACCOUNT":
                line_list = self.db[i].rstrip().split(",")
                if line_list[2] == name and line_list[0] == uname:
                    self.db[i] = f"{uname},ACCOUNT,{name},{accountuname},{pwd},{category}\n"
                    self.write_database()
                    break
    
    def remove_account(self,uname,name):
        for i in range(len(self.db)):
            if checkRow(self.db[i]) == "ACCOUNT":
                line_list = self.db[i].rstrip().split(",")
                if line_list[2] == name and line_list[0] == uname:
                    self.db.remove(self.db[i])
                    self.write_database()
                    break
                
                
class password:
    @staticmethod
    def makepassword():
        capitalLetters = 4
        lowercaseLetters = 4
        numbers = 4
        specialCharacters = 4
        password =[]
        finalpass=""
        for i in range(capitalLetters):
            password.append(random.randint(65, 90))
        for i in range(lowercaseLetters):
            password.append(random.randint(97, 122))
        for i in range(numbers):
            password.append(random.randint(48, 57))
        special=[33,64,35,36,37,94,38,42,40,41]
        for i in range(specialCharacters):
            password.append(random.choice(special))
        decrypted = [chr(x) for x in password]
        randomized=random.shuffle(decrypted)

        for x in decrypted:
            finalpass += x
        
        return finalpass

