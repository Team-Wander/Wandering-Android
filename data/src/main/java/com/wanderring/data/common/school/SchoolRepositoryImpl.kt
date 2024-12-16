package com.wanderring.data.common.school

import com.wanderring.domain.repository.SchoolRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SchoolRepositoryImpl @Inject constructor(
    private val schoolDataSource: SchoolDataSource,
) : SchoolRepository {
    override suspend fun getSchoolList(searchSchulNm: String, gubun: String): Flow<List<String>> =
        schoolDataSource.getSchoolList(
            searchSchulNm = searchSchulNm,
            gubun = gubun,
        )
            .map {
                it.dataSearch?.content?.mapNotNull { content ->
                    content.schoolName
                } ?: emptyList()
            }
}