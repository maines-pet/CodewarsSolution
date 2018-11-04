fun babyCount(x: String): Int? {
    val filter : (Char) -> Boolean = {
        input -> when (input) {
                        'a', 'b', 'y' -> true
                        else -> false
                    }
    }
    val map = mutableMapOf('b' to 0, 'a' to 0, 'y' to 0)
    val effectiveStrings = x.map{ it.toLowerCase() }.filter(filter)
    if (effectiveStrings.isEmpty()) return null

    for (c in effectiveStrings) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    map['b'] = map['b']!! / 2
    val result = map.values.min()
    return if (result == 0) null else result
}
