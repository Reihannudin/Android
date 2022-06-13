package udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data.component

import dagger.Component
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.HiltDIActivity
import udemy.course.summary.android.myapplication.dependency.injection.training.demo.hilt.data.DataHiltModule

@Component(modules = [DataHiltModule::class])
interface DataHiltComponent {
    fun inject(HiltDIActivity: HiltDIActivity)
}