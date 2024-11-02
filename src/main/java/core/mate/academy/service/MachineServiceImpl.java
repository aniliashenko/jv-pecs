package core.mate.academy.service;

import core.mate.academy.model.Machine;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Machine.class) {
            return List.of();
        }

        try {
            try {
                return List.of(type.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        if (!machines.isEmpty()) {
            for (int i = 0; i < machines.size(); i++) {
                machines.set(i, value);
            }
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {

    }
}
