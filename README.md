# Hockey Process Metrics Analyzer

This project is a Java application that calculates **process-outcome metrics** for hockey matches.  
It’s designed to help coaches and analysts move beyond raw counts (shots, corners, entries) and understand the *quality and efficiency* of play.

---

## 📊 Features

- **Open-play Expected Goals (xG)**: estimates chance quality from shots.  
- **Penalty Corner xG (PC-xG)**: values set-piece opportunities.  
- **Shot Quality Index (SQI)**: average xG per shot.  
- **Entry-to-Shot Conversion (ESC)**: how often circle penetrations lead to shots.  
- **xG per Circle Penetration (xG/E)**: quality of entries.  
- **Twenty-Five to Circle Progression Index (TPI)**: efficiency of converting 25-yard entries into circle possessions.  
- **Process Dominance Index (PDI)**: composite score combining open play, PCs, progression, and conversion.  
- **Retention vs Loss Differential (RLD)**: compares possession retention between aerials and floor play.  
- **Coach-facing report**: prints all metrics side by side for quick post-match review.

---

## 🏗️ Project Structure

- `TeamStats.java`  
  Encapsulates raw inputs (shots, goals, entries, corners, aerial/floor stats) and computes derived metrics.

- `MatchAnalysis.java`  
  Compares two `TeamStats` objects (Loughborough vs Opponent), calculates composite indices (PDI, RLD), and prints a structured report.

- `HockeyStatsApp.java`  
  Main driver program. Prompts for inputs, builds team objects, runs analysis, and outputs results.

---

## 🚀 Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/hockey-metrics-analyzer.git
   cd hockey-metrics-analyzer
