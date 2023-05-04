package com.huaxiti;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import difflib.DiffAlgorithm;
import difflib.*;
import difflib.DiffAlgorithm;
//import difflib.DiffAlgorithmChooser;
import difflib.DiffUtils;
import difflib.Patch;

/**
 * DiffUtils库提供了多种计算差异的算法，每种算法都有其特点和适用范围。以下是DiffUtils库常用算法的简要介绍：
 *
 * Myers算法
 * Myers算法是DiffUtils库默认的算法，也是最常用的算法。它的特点是简单、快速，适用于大部分场景。但是对于某些特殊情况（例如长文本对比）可能会效率较低。
 *
 * LCS算法
 * LCS（Longest Common Subsequence）算法是DiffUtils库提供的另一种算法。它的特点是准确性高，适用于文本相似度比较高的情况。但是它的效率较低，计算时间可能较长。
 *
 * Hirschberg算法
 * Hirschberg算法是一种分治算法，它将计算差异的过程划分为两个子问题，递归求解。它的特点是对于某些情况（例如DNA序列对比）具有较高的效率。但是它的实现较为复杂，难以理解和调试。
 *
 * MyersGreedy算法
 * MyersGreedy算法是一种基于Myers算法的优化算法，它在Myers算法的基础上加入了一些优化策略。它的特点是在保持较高准确度的情况下，效率较高。
 *
 * 以上是DiffUtils库常用算法的简要介绍，需要根据实际需求选择不同的算法。如果对比的文本较短且对准确性要求不高，可以选择Myers算法。如果对比的文本较长或对准确性要求较高，可以选择LCS算法。如果对比的文本具有特殊的结构或格式，可以考虑Hirschberg算法。如果希望在保持准确性的同时提高效率，可以考虑MyersGreedy算法。
 */
public class demo {

    public static void main(String[] args) throws IOException {
        // 读取需要对比的两个文件
        String content1 = readFile("C:\\Users\\hx\\Desktop\\QQ202303231536_OCR\\result.txt");
        String content2 = readFile("C:\\Users\\hx\\Desktop\\QQ202303231536_OCR\\result2.txt");
        List<String> file1Lines = Arrays.asList(content1.split("\r\n"));
        List<String> file2Lines = Arrays.asList(content2.split("\r\n"));
//        DiffAlgorithm.SupportedAlgorithm = DiffAlgorithm.LCS;
        // 计算差异并输出结果
        DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder();
        builder.showInlineDiffs(false);

        DiffRowGenerator dfg = builder.build();
        List<DiffRow> rows = dfg.generateDiffRows(file1Lines, file2Lines);
        for (DiffRow row : rows) {
            System.out.println(row);
        }
    }

    // 读取文件内容
    private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }



}

