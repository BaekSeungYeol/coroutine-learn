package section1.test

class AddUseCase {
    fun add(vararg args: Int): Int {
        return args.sum()
    }
}