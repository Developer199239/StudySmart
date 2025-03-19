package com.wordpress.murtuzarahman.studysmart.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.wordpress.murtuzarahman.studysmart.domain.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository
): ViewModel() {


}