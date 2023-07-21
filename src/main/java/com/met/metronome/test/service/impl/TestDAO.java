package com.met.metronome.test.service.impl;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDAO {
    String selectTest();
}
