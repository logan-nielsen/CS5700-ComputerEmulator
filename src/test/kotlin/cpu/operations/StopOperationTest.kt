package cpu.operations

import org.example.cpu.CPU
import org.example.cpu.operations.StopOperation
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class StopOperationTest {
    @Test
    fun testStop() {
        StopOperation().execute(0x000)
        assertTrue(CPU.executor.isShutdown)
    }
}