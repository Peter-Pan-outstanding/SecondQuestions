package wtc.carbon.controller;// ComplaintController.java
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.common.Result;
import wtc.carbon.entity.Complaint;
import wtc.carbon.service.ComplaintService;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Resource
    private ComplaintService complaintService;

    // 获取所有投诉记录
    @GetMapping("/list")
    public Result<?> list() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return !complaints.isEmpty()
                ? Result.success(complaints)
                : Result.error(404, "没有投诉记录");
    }

    // 根据ID获取投诉记录
    @GetMapping("/get/{id}")
    public Result<?> get(@PathVariable Integer id) {
        Complaint complaint = complaintService.getComplaintById(id);
        return complaint != null
                ? Result.success(complaint)
                : Result.error(404, "投诉记录不存在");
    }

    // 根据条件查询投诉记录
    @GetMapping("/search")
    public Result<?> search(@RequestParam(required = false) String title,
                            @RequestParam(required = false) String status) {
        List<Complaint> complaints = complaintService.searchComplaints(title, status);
        return !complaints.isEmpty()
                ? Result.success(complaints)
                : Result.error(404, "没有找到符合条件的投诉记录");
    }

    // 新增投诉记录
    @PostMapping("/save")
    public Result<?> save(@RequestBody Complaint complaint) {
        boolean isSaved = complaintService.saveComplaint(complaint);
        return isSaved
                ? Result.success("投诉记录已提交")
                : Result.error(400, "提交失败");
    }

    // 更新投诉记录
    @PutMapping("/update")
    public Result<?> update(@RequestBody Complaint complaint) {
        boolean isUpdated = complaintService.updateComplaint(complaint);
        return isUpdated
                ? Result.success("投诉记录更新成功")
                : Result.error(400, "更新失败，请检查投诉ID");
    }

    // 删除投诉记录
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        boolean isDeleted = complaintService.deleteComplaint(id);
        return isDeleted
                ? Result.success("投诉记录删除成功")
                : Result.error(400, "删除失败，请联系管理员");
    }
}
