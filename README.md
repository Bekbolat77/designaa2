# Assignment 2: Insertion Sort & Selection Sort  

This repository contains two implemented algorithms:  
- **Insertion Sort** – Bekbolat  
- **Selection Sort** – Yesbol  

## Project Overview  
We implemented and analyzed two basic quadratic sorting algorithms. Both algorithms have the same worst-case time complexity of **O(n²)**, but their behavior differs:  
- **Insertion Sort** performs efficiently on small or nearly sorted arrays, especially with binary insertion optimization.  
- **Selection Sort** always performs the same number of comparisons, but requires fewer swaps compared to Insertion Sort.  

## Results  
- Insertion Sort outperforms Selection Sort on small datasets.  
- Selection Sort becomes more efficient on large datasets, since it minimizes swaps even though it performs many comparisons.  

All benchmark results are saved in **`benchmark_results.csv`**.  
Performance plots are available in **`docs/performance-plots/`**.  

## Reports  
- `docs/Report2_T.Bekbolat_15grp.pdf`  
- `docs/Report2_B.Yesbol_15grp.pdf`  

## Authors  
- Bekbolat  
- Yesbol  
