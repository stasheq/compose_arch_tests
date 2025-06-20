import ComposeApp

class IOSLogger: CoreLogger {
    func log(message: String) {
        print(message)
    }
    
    func logError(message: String) {
        print(message)
    }
}
