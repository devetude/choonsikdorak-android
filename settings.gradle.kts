rootProject.name = "choonsikdorak-android"

includeAppModules()
includeUiModules()
includeDomainModules()
includeDataModules()

fun includeAppModules() {
    val parentName = "app"
    val childNames = setOf("android", "wear")
    val modules = createModulePaths(parentName, childNames)
    modules.forEach(::include)
}

fun includeUiModules() {
    val parentName = "ui"
    val childNames = setOf("android", "wear")
    val modules = createModulePaths(parentName, childNames)
    modules.forEach(::include)
}

fun includeDomainModules() {
    val parentName = "domain"
    val childNames = setOf("auth", "menu", "setting")
    val modules = createModulePaths(parentName, childNames)
    modules.forEach(::include)
}

fun includeDataModules() {
    val parentName = "data"
    val childNames = setOf("repository", "local", "remote")
    val modules = createModulePaths(parentName, childNames)
    modules.forEach(::include)
}

fun createModulePaths(parentName: String, childNames: Set<String>): List<String> =
    childNames.map { childName -> ":$parentName:$childName" }
