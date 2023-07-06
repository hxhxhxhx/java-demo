package com.huaxiti;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.Patch;
import com.github.difflib.patch.PatchFailedException;

public class FileDiffUtils {
    public static void main(String[] args) throws IOException, PatchFailedException {
        // 读取原始文件和修改后的文件
        File originalFile = new File("original.txt");
        File revisedFile = new File("revised.txt");
        List<String> originalLines = Files.readAllLines(originalFile.toPath(), StandardCharsets.UTF_8);
        List<String> revisedLines = Files.readAllLines(revisedFile.toPath(), StandardCharsets.UTF_8);

        // 计算差异
        Patch<String> patch = DiffUtils.diff(originalLines, revisedLines);
//        List<String> diff = StringUtills.diffToList(patch);
//
//        // 输出差异
//        System.out.println("Diff:");
//        for (String line : diff) {
//            System.out.println(line);
//        }
    }
}
