package com.huaxiti;

import difflib.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

class FileComparator {
    private DiffAlgorithm algorithm;

    public FileComparator() {
//        this.algorithm = DiffAlgorithm.MYERS; // 默认算法为Myers算法
    }

    public FileComparator(DiffAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(DiffAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Patch<String> compare(File original, File revised) throws IOException {
        List<String> originalLines = FileUtils.readLines(original, "UTF-8");
        List<String> revisedLines = FileUtils.readLines(revised, "UTF-8");
        return DiffUtils.diff(originalLines, revisedLines, algorithm);
    }

    public static void main(String[] args) {

        try {
            File original = new File("original.txt");
            File revised = new File("revised.txt");

            // 使用默认算法Myers进行对比
            FileComparator comparator = new FileComparator();
            Patch<String> patch = comparator.compare(original, revised);

            // 切换算法为LCS
//            comparator.setAlgorithm(DiffAlgorithm.LCS);
            Patch<String> patchLCS = comparator.compare(original, revised);

            // 输出差异
            System.out.println("=== Default Algorithm (Myers) ===");
            for (Delta<String> delta : patch.getDeltas()) {
                System.out.println(delta.getType() + " " + delta.getOriginal() + " -> " + delta.getRevised());
            }

            System.out.println("\n=== LCS Algorithm ===");
            for (Delta<String> delta : patchLCS.getDeltas()) {
                System.out.println(delta.getType() + " " + delta.getOriginal() + " -> " + delta.getRevised());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
