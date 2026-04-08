package com.restaurant.btth.service;

import com.restaurant.btth.model.RestaurantTable;
import com.restaurant.btth.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository repository;

    @Autowired
    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<RestaurantTable> filterByCapacity(int cap) {
        if (cap < 0) return repository.findAll(); // bẫy dữ liệu
        return repository.findAll()
                .stream()
                .filter(t -> t.getCapacity() >= cap)
                .collect(Collectors.toList());
    }

    public RestaurantTable getById(int id) {
        return repository.findById(id);
    }

    public void updateStatus(int id, String status) {
        RestaurantTable t = repository.findById(id);
        if (t != null) {
            t.setStatus(status);
        }
    }

    public String delete(int id) {
        RestaurantTable t = repository.findById(id);
        if (t != null && "Đang dùng".equals(t.getStatus())) {
            return "Không thể xóa bàn đang có khách";
        }
        repository.delete(id);
        return "Xóa thành công";
    }
}
