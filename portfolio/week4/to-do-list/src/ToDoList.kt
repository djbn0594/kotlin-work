// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted get() = items.count{it.status == ItemStatus.NotStarted}   // compute no. of items with NotStarted status
    val inProgress get() = items.count{it.status == ItemStatus.InProgress}   // compute no. of items with InProgress status
    val done get() = items.count{it.status == ItemStatus.Done}          // compute no. of items with Done status
    //val overdue get() = items.count{it.dueDate < LocalDate.now() && it.status != ItemStatus.Done}      // compute no. of overdue items

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
        val filePath = Path(filename)
        
        filePath.forEachLine {
            val parts = it.split(":")
            val item = ToDoItem(LocalDate.parse(parts[0]), ItemStatus.valueOf(parts[1]), parts[2])
            items.add(item)
        }
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        val len = items.size
        items.removeAll { it.status == ItemStatus.Done }
        return items.size < len
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        val filtered = items.filter{it.status == status}
        return filtered
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        val filtered = items.filter{it.dueDate == date}
        return filtered
    }
}
