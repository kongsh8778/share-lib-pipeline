//vars/uSendMail.groovy
def call(String subject,String to){
	def text = '''
<!DOCTYPE html>    
<html>    
	<head>    
	<meta charset="UTF-8">    
	<title>${ENV, var="JOB_NAME"}-��${BUILD_NUMBER}�ι�����־</title>    
	</head>  
	
    <body leftmargin="8" marginwidth="0" topmargin="8" marginheight="4"    offset="0">    
    <table width="95%" cellpadding="0" cellspacing="0"  style="font-size: 11pt; font-family: Tahoma, Arial, Helvetica, sans-serif">    
        <tr>    
            ���ʼ���ϵͳ�Զ�����������ظ���<br/>            
            ��λͬ�£���Һã�����Ϊ${PROJECT_NAME }��Ŀ������Ϣ</br> 
            <td><font color="#CC0000">������� - ${BUILD_STATUS}</font></td>   
        </tr>    
        <tr>    
            <td><br />    
            <b><font color="#0B610B">������Ϣ</font></b>    
            <hr size="2" width="100%" align="center" /></td>    
        </tr>    
        <tr>    
            <td>    
                <ul>    
                    <li>��Ŀ���� �� ${PROJECT_NAME}</li>    
                    <li>������� �� ��${BUILD_NUMBER}�ι���</li>    
                    <li>����ԭ�� ${CAUSE}</li>    
                    <li>����״̬�� ${BUILD_STATUS}</li>    
                    <li>������־�� <a href="${BUILD_URL}console">${BUILD_URL}console</a></li>    
                    <li>����  Url �� <a href="${BUILD_URL}">${BUILD_URL}</a></li>    
                    <li>����Ŀ¼ �� <a href="${PROJECT_URL}ws">${PROJECT_URL}ws</a></li>    
                    <li>��Ŀ  Url �� <a href="${PROJECT_URL}">${PROJECT_URL}</a></li>    
                </ul>    
				<h4><font color="#0B610B">ʧ������</font></h4><hr size="2" width="100%" />
				$FAILED_TESTS<br/>
				<h4><font color="#0B610B">����ύ(#$SVN_REVISION)</font></h4><hr size="2" width="100%" /><ul>
				${CHANGES_SINCE_LAST_SUCCESS, reverse=true, format="%c", changesFormat="<li>%d [%a] %m</li>"}</ul>
				��ϸ�ύ: <a href="${PROJECT_URL}changes">${PROJECT_URL}changes</a><br/>

            </td>    
        </tr>    
    </table>    
	</body>    
	
</html> '''
	emailext attachLog: true, body: text, compressLog: true, mimeType: 'text/html', subject: subject, to: to
	
}