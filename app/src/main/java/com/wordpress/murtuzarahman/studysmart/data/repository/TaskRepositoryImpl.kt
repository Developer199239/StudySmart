package com.wordpress.murtuzarahman.studysmart.data.repository


import com.wordpress.murtuzarahman.studysmart.data.local.TaskDao
import com.wordpress.murtuzarahman.studysmart.domain.model.Task
import com.wordpress.murtuzarahman.studysmart.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
): TaskRepository {

    override suspend fun upsertTask(task: Task) {
        taskDao.upsertTask(task)
    }

    override suspend fun deleteTask(taskId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskById(taskId: Int): Task? {
        TODO("Not yet implemented")
    }

    override fun getUpcomingTasksForSubject(subjectInt: Int): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override fun getCompletedTasksForSubject(subjectInt: Int): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override fun getAllUpcomingTasks(): Flow<List<Task>> {
        TODO("Not yet implemented")
    }
}