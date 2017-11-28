import smtplib
import sys
from_=sys.argv[1]
msg=sys.argv[2]
pwd=sys.argv[3]
to_=sys.argv[4]
server = smtplib.SMTP('smtp.gmail.com',587)
server.starttls()
server.login(from_,pwd)

server.sendmail(from_,to_,msg)
server.quit()
