package com.thebasics.blogsapi.viewmodel;

import java.util.List;

public record ResDataVm<T>(int code, String msg, List<T> data) {

}
