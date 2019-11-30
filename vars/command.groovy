//vars/command.groovy
def setCommand(comm){
	cmd = comm
}

def getCommand(){
	cmd
}

def runCommand(){
	cdmout = bat label: '', script: '${cmd}'
}

def getOutput(){
	cdmout
}


