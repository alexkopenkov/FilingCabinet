interface BuildTypes {

    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val appName: String
}

object BuildTypeDebug : BuildTypes {
    override val isMinifyEnabled = false
    override val appName = "Demo ${AndroidConfig.NAME}"

    const val applicationIdSuffix = ".debug"
    const val versionNameSuffix = "-DEBUG"
}

object BuildTypeRelease : BuildTypes {
    override val isMinifyEnabled = true
    override val appName = AndroidConfig.NAME
}