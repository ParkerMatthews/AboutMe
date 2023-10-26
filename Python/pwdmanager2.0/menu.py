from pwd_manager import *

break_flag = True
print('starting skynet...')
db = Database()

while break_flag:
    user_input = input("1 for new user, 2 for returning user, q to quit program: ")
    if user_input == "q":
        break_flag = False
    if user_input == "1":
        genpwd = input("Do you want a generated password? (y/n): " )
        uname = input("uname: ")
        if genpwd == "y":
            pwd = password.makepassword()
            print((f"pwd: {pwd}"))
        else:
            pwd = input("pwd: ")
        fname = input("fname: ")
        lname = input("lname: ")
        db.add_user(uname, pwd, fname, lname)
        print("User added!")
    if user_input == "2":
        uname = input("uname: ")
        pwd = input("pwd: ")
        user = db.check_user(uname, pwd)
        if user == -1:
            print('error!')
        else:
            print(f'Welcome {user.first_name} {user.last_name}!')
        login = True
        while login:
            account = input("1 to add accounts , 2 to view accounts , 3 to edit account , 4 to remove account , 5 to log out")
            if account == "1":
                genpwd = input("Do you want a generated password? (y/n): " )
                name = input("account name: ")
                accountuname = input("account username: ")
                if genpwd == "y":
                    pwd = password.makepassword()
                    print((f"pwd: {pwd}"))
                else:
                    pwd = input("pwd: ")
                category = input("Category: ")
                db.add_account(user.username,name,accountuname,pwd,category)
                print('Success!')
            if account == "5":
                login = False
                print('Success you have logged out!')
            if account == "2":
                category = input("Select Category: ")
                db.viewaccounts(user.username,category)
            if account == "3":
                name = input("What account do you want to edit: ")
                genpwd = input("Do you want a generated password? (y/n): " )
                accountuname = input("account username: ")
                if genpwd == "y":
                    pwd = password.makepassword()
                    print((f"pwd: {pwd}"))
                else:
                    pwd = input("pwd: ")
                category = input("Category: ")
                db.edit_account(user.username,name,accountuname,pwd,category)
            if account == "4":
                name = input("What account do you want to delete: ")
                db.remove_account(user.username,name)
                