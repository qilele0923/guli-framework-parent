package com.guli.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.vo.R;
import com.guli.edu.entity.Teacher;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@Api(description = "讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @ApiOperation(value = "所有讲师列表")
  @GetMapping
  public R list() {
    List<Teacher> list = teacherService.list(null);
    return R.ok().data("items", list);
  }

  @ApiOperation(value = "根据ID删除讲师")
  @DeleteMapping("{id}")
  public R removeById(
      @ApiParam(name = "id", value = "讲师ID", required = true)
      @PathVariable String id) {
    teacherService.removeById(id);
    return R.ok();
  }


  @ApiOperation(value = "分页讲师列表")
  @GetMapping("{page}/{limit}")
  public R pageList(
      @ApiParam(name = "page", value = "当前页码", required = true)
      @PathVariable Long page,

      @ApiParam(name = "limit", value = "每页记录数", required = true)
      @PathVariable Long limit) {

    Page<Teacher> pages = new Page<>(page, limit);
    teacherService.page(pages, null);
    List<Teacher> records = pages.getRecords();
    long total = pages.getTotal();

    return R.ok().data("total", total).data("rows", records);
  }


  @ApiOperation(value = "新增讲师")
  @PostMapping
  public R save(
      @ApiParam(name = "teacher", value = "讲师对象", required = true)
      @RequestBody Teacher teacher){

    teacherService.save(teacher);
    return R.ok();
  }


  @ApiOperation(value = "根据ID查询讲师")
  @GetMapping("{id}")
  public R getById(
      @ApiParam(name = "id", value = "讲师ID", required = true)
      @PathVariable String id){

    Teacher teacher = teacherService.getById(id);
    return R.ok().data("item", teacher);
  }

  @ApiOperation(value = "根据ID修改讲师")
  @PutMapping("{id}")
  public R updateById(
      @ApiParam(name = "id", value = "讲师ID", required = true)
      @PathVariable String id,

      @ApiParam(name = "teacher", value = "讲师对象", required = true)
      @RequestBody Teacher teacher){

    teacher.setId(id);
    teacherService.updateById(teacher);
    return R.ok();
  }
}
