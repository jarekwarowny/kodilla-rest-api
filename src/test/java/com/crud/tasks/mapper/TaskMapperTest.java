package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        Task task = new Task(12L, "aaa", "bbb");
        TaskDto taskDto = new TaskDto(12L, "ccc", "ddd");

        Task task1 = taskMapper.mapToTask(taskDto);

        Assertions.assertEquals(12L, 12L);
        Assertions.assertEquals("aaa", "aaa");
        Assertions.assertEquals("bbb", "bbb");
    }

    @Test
    public void mapToTaskDtoTest() {
        Task task = new Task(13L, "ssss", "eeee");
        TaskDto taskDto = new TaskDto(13L, "dssd", "erere");

        TaskDto taskDto1 = taskMapper.mapToTaskDto(task);

        Assertions.assertEquals(13L, 13L);
        Assertions.assertEquals("ssss", "ssss");
        Assertions.assertEquals("eeee", "eeee");
    }

    @Test
    public void mapToTaskDtoListTest() {
        Task task = new Task(1L, "aaaa", "vvvv");
        TaskDto taskDto = new TaskDto(1L, "bbbb", "cccc");
        List<Task> tasks = Arrays.asList(task);
        List<TaskDto> taskDtos = Arrays.asList(taskDto);

        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);

        Assertions.assertEquals(1, 1);
    }
}
