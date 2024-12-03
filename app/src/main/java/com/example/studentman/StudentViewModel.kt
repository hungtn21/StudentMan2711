package com.example.studentman

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {

    // Tách việc khởi tạo danh sách sinh viên ra thành một phương thức riêng.
    private val _students = MutableLiveData<List<StudentModel>>().apply {
        value = initializeStudents()
    }
    val students: LiveData<List<StudentModel>> get() = _students

    // Phương thức khởi tạo danh sách sinh viên
    private fun initializeStudents(): List<StudentModel> {
        return listOf(
            StudentModel("Nguyễn Nhật Minh", "20225012"),
            StudentModel("Trần Thu Hằng", "20225145"),
            StudentModel("Lê Anh Dũng", "20225203"),
            StudentModel("Phạm Bảo Ngọc", "20225367"),
            StudentModel("Đỗ Quang Huy", "20225421"),
            StudentModel("Vũ Phương Thảo", "20225589"),
            StudentModel("Hoàng Minh Châu", "20225643"),
            StudentModel("Bùi Văn Khánh", "20225712"),
            StudentModel("Đinh Thanh Bình", "20225801"),
            StudentModel("Nguyễn Khánh Linh", "20225998"),
            StudentModel("Phạm Ngọc Lan", "20225034"),
            StudentModel("Trần Thanh Tâm", "20225127"),
            StudentModel("Lê Gia Bảo", "20225256"),
            StudentModel("Vũ Hải Đăng", "20225314"),
            StudentModel("Hoàng Thiên An", "20225478"),
            StudentModel("Đỗ Xuân Hoàng", "20225523"),
            StudentModel("Nguyễn Phương Mai", "20225692"),
            StudentModel("Trần Minh Khoa", "20225789"),
            StudentModel("Phạm Anh Tú", "20225855"),
            StudentModel("Lê Quỳnh Chi", "20225901")

        )
    }

    // Thêm sinh viên mới vào danh sách
    fun addStudent(student: StudentModel) {
        val updatedList = _students.value?.toMutableList() ?: mutableListOf()
        updatedList.add(student)
        _students.postValue(updatedList)
    }

    // Cập nhật thông tin sinh viên theo id
    fun updateStudent(oldId: String, newName: String, newId: String) {
        val updatedList = _students.value?.map {
            if (it.studentId == oldId) it.copy(studentName = newName, studentId = newId)
            else it
        } ?: return
        _students.postValue(updatedList)
    }

    // Xóa sinh viên khỏi danh sách
    fun deleteStudent(student: StudentModel) {
        val updatedList = _students.value?.toMutableList()?.apply {
            remove(student)
        } ?: return
        _students.postValue(updatedList)
    }

    // Lấy thông tin sinh viên theo id
    fun getStudentById(id: String?): StudentModel? {
        return _students.value?.find { it.studentId == id }
    }
}
