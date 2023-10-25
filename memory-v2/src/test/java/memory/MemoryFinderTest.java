package memory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemoryFinderTest {

	@Test
	void get() {
		// given
		MemoryFinder memoryFinder = new MemoryFinder();

		// when
		Memory memory = memoryFinder.get();

		// then
		assertThat(memory).isNotNull();
	}

}
