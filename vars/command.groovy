//vars/command.groovy
def setCommand(comm){
	cmd = comm
}

def getCommand(){
	cmd
}

def runCommand(){
	bat label: '', script: '${cmd}'
}

