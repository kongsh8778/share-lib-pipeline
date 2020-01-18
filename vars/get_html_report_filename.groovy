//vars/get_html_report_filename.groovy
def call(report_store_path) {
    get_html_file_command = "cd ${report_store_path}&dir /b /s *.html"
    out = bat(script:get_html_file_command,returnStdout: true).trim()
    out = out.tokenize("\n")[1] // get the second line string
    println out
    html_report_filename = out.split("TestReport")[1].replace("\\", "")
    println html_report_filename
    return html_report_filename
}