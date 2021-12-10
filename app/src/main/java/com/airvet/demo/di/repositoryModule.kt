package com.airvet.demo.di

import com.airvet.demo.data.repository.UserRepository
import com.airvet.demo.data.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}