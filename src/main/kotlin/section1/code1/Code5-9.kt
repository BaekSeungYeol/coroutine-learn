package section1.code1

import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

suspend fun searchByKeyword2(keyword: String): Array<String> = supervisorScope {
    val dbResultsDeferred = async {
        throw Exception("DB 읽기 오류 발생")
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    val dbResults = try {
        dbResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    val serverResults = try {
        serverResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    return@supervisorScope arrayOf(*dbResults, *serverResults)
}