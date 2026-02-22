package xyz.wallpanel.app.ext

private const val ARRAY_STRING_SEPARATOR = ","

fun String.convertStringToArray(): Array<String> =
    split(ARRAY_STRING_SEPARATOR).toTypedArray()
