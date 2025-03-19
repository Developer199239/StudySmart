package com.wordpress.murtuzarahman.studysmart.di

import com.wordpress.murtuzarahman.studysmart.data.repository.SessionRepositoryImpl
import com.wordpress.murtuzarahman.studysmart.data.repository.SubjectRepositoryImpl
import com.wordpress.murtuzarahman.studysmart.data.repository.TaskRepositoryImpl
import com.wordpress.murtuzarahman.studysmart.domain.repository.SessionRepository
import com.wordpress.murtuzarahman.studysmart.domain.repository.SubjectRepository
import com.wordpress.murtuzarahman.studysmart.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
        impl: SessionRepositoryImpl
    ): SessionRepository
}