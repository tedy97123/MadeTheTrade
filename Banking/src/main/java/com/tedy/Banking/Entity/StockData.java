package com.tedy.Banking.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "")
public class StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define fields for the different data attributes you need
    private String defaultKeyStatistics;
    private String summaryProfile;
    private String recommendationTrend;
    private String financialsTemplate;
    private String majorDirectHolders;
    private String earnings;
    private Float price;
    private String fundOwnership;
    private String insiderTransactions;
    private String insiderHolders;
    private String netSharePurchaseActivity;
    private String majorHoldersBreakdown;
    private String financialData;
    private String quoteType;
    private String institutionOwnership;
    private String calendarEvents;
    private String summaryDetail;
    private String symbol;
    private String esgScores;
    private String upgradeDowngradeHistory;
    private String pageViews;
    private String details;

}
