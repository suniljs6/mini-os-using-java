from tkinter import *
from tkinter import filedialog
from tkinter import messagebox
from tkinter import font
import tkinter as tk
from tkinter import font

master = Tk()
master.title("Editor")
master.geometry("400x300")
family_ = "Helvetica"
size_ = 18
font_ = font.Font(family=family_,size=size_)
text = Text(master,width=400,height=380, font=font_,highlightthickness=0,bd=2)
text.pack()

def fontstyle():
	pass

def new():
	ans = messagebox.askquestion(title="Save File",message="Would you like to save this file")
	if ans is True:
		save()
	delete_all()
	
def open_file():
	fi = filedialog.askopenfile()
	text.insert(INSERT,fi.read())	
	
def save():
	path = filedialog.asksaveasfilename()
	fp = open(path,mode='w')
	fp.write(text.get("1.0",END))
		
def close():
	save()
	master.quit()

def cut():
	master.clipboard_clear()
	text.clipboard_append(string=text.selection_get())
	text.delete(index1=SEL_FIRST, index2=SEL_LAST)
	
def copy():
	master.clipboard_clear()
	text.clipboard_append(string=text.selection_get())
	
def paste():
	text.insert(INSERT, master.clipboard_get())
	
def delete():
	text.delete(index1=SEL_FIRST, index2=SEL_LAST)
	
def select_all():
	text.tag_add(SEL,"1.0",END)

def delete_all():
	text.delete(1.0,END)

menu = Menu(master)
master.config(menu=menu)
file_menu = Menu(menu)
menu.add_cascade(label="File",menu=file_menu)

file_menu.add_command(label="New",command=new)
file_menu.add_command(label="Open",command=open_file)
file_menu.add_separator()
file_menu.add_command(label="Save",command=save)
file_menu.add_separator()
file_menu.add_command(label="Close",command=close)


edit_menu = Menu(menu)
menu.add_cascade(label="Edit",menu=edit_menu)
edit_menu.add_command(label="Undo",command=text.edit_undo)
edit_menu.add_command(label="Redo",command=text.edit_redo)
edit_menu.add_separator()
edit_menu.add_command(label="Cut",command=cut)
edit_menu.add_command(label="Copy",command=copy)
edit_menu.add_command(label="Paste",command=paste)
edit_menu.add_command(label="Delete",command=delete)
edit_menu.add_separator()
edit_menu.add_command(label="Select All",command=select_all)


font_style = Menu(menu)
menu.add_cascade(label="font_style",menu=font_style)
font_family =  Menu(menu)	
font_style.add_cascade(label="font-family",menu=font_family)
font_size = Menu(menu)
font_style.add_cascade(label="font-size",menu=font_size)

a = list(font.families())

def font0():
	family_ = a[0]
	text.config(font=(family_,size_)) 

def font1():
	family_ = a[1]
	text.config(font=(family_,size_))

def font2():
	family_ = a[2]
	text.config(font=(family_,size_))

def font3():
	family_ = a[3]
	text.config(font=(family_,size_))

def font4():
	family_ = a[4]
	text.config(font=(family_,size_))

def font5():
	family_ = a[5]
	text.config(font=(family_,size_))

def font6():
	family_ = a[6]
	text.config(font=(family_,size_))

def font7():
	family_ = a[7]
	text.config(font=(family_,size_))

def font8():
	family_ = a[8]
	text.config(font=(family_,size_))

def font9():
	family_ = a[9]
	text.config(font=(family_,size_))

def font10():
	family_ = a[10]
	text.config(font=(family_,size_))

def font11():
	family_ = a[11]
	text.config(font=(family_,size_))


#size

def size10():
	size_ = 10
	text.config(font=(family_,size_))

def size20():
	size_ = 20
	text.config(font=(family_,size_))

def size30():
	size_ = 30
	text.config(font=(family_,size_))

def size35():
	size_ = 35
	text.config(font=(family_,size_))

def size40():
	size_ = 40
	text.config(font=(family_,size_))

def size45():
	size_ = 45
	text.config(font=(family_,size_))

def size50():
	size_ = 50
	text.config(font=(family_,size_))

def size55():
	size_ = 55
	text.config(font=(family_,size_))

def size60():
	size_ = 60
	text.config(font=(family_,size_))

def size65():
	size_ = 65
	text.config(font=(family_,size_))

def size70():
	size_ = 70
	text.config(font=(family_,size_))


font_family.add_command(label=a[0],command=font0)
font_family.add_command(label=a[1],command=font1)
font_family.add_command(label=a[2],command=font2)
font_family.add_command(label=a[3],command=font3)
font_family.add_command(label=a[4],command=font4)
font_family.add_command(label=a[5],command=font5)
font_family.add_command(label=a[6],command=font6)
font_family.add_command(label=a[7],command=font7)
font_family.add_command(label=a[8],command=font8)
font_family.add_command(label=a[9],command=font9)
font_family.add_command(label=a[10],command=font10)
font_family.add_command(label=a[11],command=font11)



font_size.add_command(label=10,command=size10)
font_size.add_command(label=20,command=size20)
font_size.add_command(label=30,command=size30)
font_size.add_command(label=35,command=size35)
font_size.add_command(label=40,command=size40)
font_size.add_command(label=45,command=size45)
font_size.add_command(label=50,command=size50)
font_size.add_command(label=55,command=size55)
font_size.add_command(label=60,command=size60)
font_size.add_command(label=65,command=size65)
font_size.add_command(label=70,command=size70)

master.mainloop()
