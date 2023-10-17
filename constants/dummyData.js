const categories = [
    {
        id: 0,
        title: "Stock Trading Basics",
        thumbnail: require("../assets/images/bg_1.png")
    },
    {
        id: 1,
        title: "Technical Analysis",
        thumbnail: require("../assets/images/bg_2.png")
    },
    {
        id: 2,
        title: "Day Trading Strategies",
        thumbnail: require("../assets/images/bg_3.png")
    },
    {
        id: 3,
        title: "Options Trading",
        thumbnail: require("../assets/images/bg_4.png")
    },
    {
        id: 4,
        title: "Risk Management",
        thumbnail: require("../assets/images/bg_5.png")
    },
    {
        id: 5,
        title: "Advanced Trading Techniques",
        thumbnail: require("../assets/images/bg_6.png")
    }
];

const courses_list_1 = [
    {
        id: 0,
        title: "Stock Trading Fundamentals",
        duration: "2h 30m",
        thumbnail: require("../assets/images/thumbnail_1.png")
    },
    {
        id: 1,
        title: "Introduction to Technical Analysis",
        duration: "1h 30m",
        thumbnail: require("../assets/images/thumbnail_2.png")
    },
    {
        id: 2,
        title: "Mastering Candlestick Charting",
        duration: "2h 15m",
        thumbnail: require("../assets/images/thumbnail_3.png")
    },
    {
        id: 3,
        title: "Portfolio Management Essentials",
        duration: "3h 10m",
        thumbnail: require("../assets/images/thumbnail_4.png")
    },
    {
        id: 4,
        title: "Understanding Market Indicators",
        duration: "2h 45m",
        thumbnail: require("../assets/images/thumbnail_1.png")
    },
    {
        id: 5,
        title: "Risk Management in Trading",
        duration: "2h 20m",
        thumbnail: require("../assets/images/thumbnail_3.png")
    },
    {
        id: 6,
        title: "Advanced Trading Strategies",
        duration: "3h 50m",
        thumbnail: require("../assets/images/thumbnail_2.png")
    }
];

const courses_list_2 = [
    {
        id: 0,
        title: "Day Trading Mastery",
        duration: "2h 30m",
        instructor: "John Smith",
        ratings: 4.8,
        is_favourite: true,
        thumbnail: require("../assets/images/thumbnail_3.png")
    },
    {
        id: 1,
        title: "Options Trading Strategies",
        duration: "2h 30m",
        instructor: "Sarah Davis",
        ratings: 4.7,
        is_favourite: false,
        thumbnail: require("../assets/images/thumbnail_4.png")
    },
    {
        id: 2,
        title: "Advanced Risk Management",
        duration: "2h 30m",
        instructor: "Michael Johnson",
        ratings: 4.9,
        is_favourite: true,
        thumbnail: require("../assets/images/thumbnail_3.png")
    },
    {
        id: 3,
        title: "Trading with Candlestick Patterns",
        duration: "2h 30m",
        instructor: "Emily White",
        ratings: 4.8,
        is_favourite: false,
        thumbnail: require("../assets/images/thumbnail_2.png")
    },
    {
        id: 4,
        title: "Advanced Trading Strategies",
        duration: "2h 30m",
        instructor: "Robert Johnson",
        ratings: 4.7,
        is_favourite: false,
        thumbnail: require("../assets/images/thumbnail_4.png")
    },
    {
        id: 5,
        title: "Swing Trading for Beginners",
        duration: "2h 30m",
        instructor: "Linda Wilson",
        ratings: 4.8,
        is_favourite: false,
        thumbnail: require("../assets/images/thumbnail_4.png")
    }
];

const top_searches = [
    {
        id: 0,
        label: "Stock Analysis"
    },
    {
        id: 1,
        label: "Day Trading"
    },
    {
        id: 2,
        label: "Options Strategies"
    },
    {
        id: 3,
        label: "Risk Management"
    },
    {
        id: 4,
        label: "Candlestick Patterns"
    },
    {
        id: 5,
        label: "Swing Trading"
    }
];

const course_details = {
    id: 0,
    title: "Day Trading Mastery",
    number_of_students: "25.7k Students",
    duration: "2h 30m",
    instructor: {
        name: "John Smith",
        title: "Professional Trader"
    },
    videos: [
        {
            title: "1. Introduction to Day Trading",
            duration: "1:37",
            size: "10 MB",
            progress: "100%",
            is_playing: false,
            is_complete: true,
            is_lock: false,
            is_downloaded: false,
        },
        {
            title: "2. Technical Analysis Basics",
            duration: "1h:15:00",
            size: "200 MB",
            progress: "100%",
            is_playing: true,
            is_complete: false,
            is_lock: false,
            is_downloaded: true,
        },
        {
            title: "3. Advanced Day Trading Strategies",
            duration: "1h:27:00",
            size: "230 MB",
            progress: "0%",
            is_playing: false,
            is_complete: false,
            is_lock: true,
            is_downloaded: false,
        }
    ],
    students_count: 25700, // Updated to include student count
    files: [
        {
            id: 0,
            name: "Day Trading Strategies Guide",
            author: "John Smith",
            upload_date: "10th Oct 2023",
            thumbnail: require("../assets/images/pdf.png")
        },
        {
            id: 1,
            name: "Technical Analysis Workbook",
            author: "John Smith",
            upload_date: "8th Oct 2023",
            thumbnail: require("../assets/images/doc.png")
        }
    ],
    discussions: [
        {
            id: 0,
            profile: require("../assets/images/profile.png"),
            name: "John Smith",
            no_of_comments: "8 comments",
            no_of_likes: "42 likes",
            posted_on: "2 days ago",
            comment: "Let's discuss day trading strategies and share your experiences here.",
            replies: [
                {
                    id: 0,
                    profile: require("../assets/images/student_1.png"),
                    name: "Student 1",
                    posted_on: "1 day ago",
                    comment: "I found the technical analysis section really helpful."
                },
                {
                    id: 1,
                    profile: require("../assets/images/student_2.png"),
                    name: "Student 2",
                    posted_on: "1 day ago",
                    comment: "What's your favorite trading platform?"
                }
            ]
        }
    ]
};

const notificationByDays = [
    {
        title: "Today",
        data: [
            {
                id: 1,
                avatar: require("../assets/images/student_1.png"),
                name: "Admin",
                created_at: "2h 47m ago",
                message: "New course on Swing Trading has been added."
            },
            {
                id: 2,
                avatar: require("../assets/images/student_2.png"),
                name: "Customer Care",
                created_at: "3h 02m ago",
                message: "Get a 10% discount on your next course purchase with code: TRADER10."
            }
        ]
    },
    {
        title: "Yesterday",
        data: [
            {
                id: 3,
                avatar: require("../assets/images/student_3.png"),
                name: "Lilian Ellis",
                created_at: "16h 47m ago",
                message: "Recommended: Advanced Risk Management course for traders."
            }
        ]
    }
];

export default {
    categories,
    courses_list_1,
    courses_list_2,
    top_searches,
    course_details,
    notificationByDays,
};
