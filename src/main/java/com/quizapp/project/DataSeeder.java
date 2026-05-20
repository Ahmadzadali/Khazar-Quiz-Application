package com.quizapp.project;

import com.quizapp.project.model.*;
import com.quizapp.project.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final com.quizapp.project.repository.QuizRepository quizRepo;
    private final com.quizapp.project.repository.QuestionRepository questionRepo;
    private final com.quizapp.project.repository.UserRepository userRepo;
    private final com.quizapp.project.repository.ResultRepository resultRepo;
    private final PasswordEncoder passwordEncoder;

    @org.springframework.beans.factory.annotation.Value("${app.admin.username}")
    private String adminUsername;

    @org.springframework.beans.factory.annotation.Value("${app.admin.password}")
    private String adminPassword;

    public DataSeeder(
            com.quizapp.project.repository.QuizRepository quizRepo,
            com.quizapp.project.repository.QuestionRepository questionRepo,
            com.quizapp.project.repository.UserRepository userRepo,
            com.quizapp.project.repository.ResultRepository resultRepo,
            PasswordEncoder passwordEncoder) {
        this.quizRepo = quizRepo;
        this.questionRepo = questionRepo;
        this.userRepo = userRepo;
        this.resultRepo = resultRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean quizzesExist = quizRepo.count() > 0;

        if (!quizzesExist) {
            Quiz science = new Quiz();
            science.setName("Science & Nature");
            science.setCategory("science");
            science.setTimeLimitInSeconds(300);
            quizRepo.save(science);

            List<Object[]> scienceQ = List.of(
                    new Object[] { "What is the chemical symbol for water?", "H2O", "CO2", "NaCl", "O2", "A" },
                    new Object[] { "Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn",
                            "B" },
                    new Object[] { "What gas do plants absorb from the atmosphere?", "Oxygen", "Nitrogen",
                            "Carbon Dioxide", "Hydrogen", "C" },
                    new Object[] { "How many bones are in the adult human body?", "196", "206", "216", "226", "B" },
                    new Object[] { "What is the speed of light (approx)?", "150,000 km/s", "300,000 km/s",
                            "450,000 km/s", "600,000 km/s", "B" },
                    new Object[] { "Which organ produces insulin?", "Liver", "Kidney", "Pancreas", "Heart", "C" },
                    new Object[] { "What is the atomic number of carbon?", "4", "6", "8", "12", "B" },
                    new Object[] { "Which is the largest ocean on Earth?", "Atlantic", "Indian", "Arctic", "Pacific",
                            "D" },
                    new Object[] { "What force keeps us on the ground?", "Magnetism", "Gravity", "Friction", "Tension",
                            "B" },
                    new Object[] { "DNA stands for?", "Deoxyribonucleic Acid", "Diribonucleic Acid",
                            "Deoxyribose Nucleic Agent", "Dynamic Nucleic Acid", "A" });
            for (Object[] q : scienceQ) {
                Question question = new Question();
                question.setQuestionText((String) q[0]);
                question.setOptionA((String) q[1]);
                question.setOptionB((String) q[2]);
                question.setOptionC((String) q[3]);
                question.setOptionD((String) q[4]);
                question.setCorrectAnswer((String) q[5]);
                question.setQuiz(science);
                questionRepo.save(question);
            }

            Quiz tech = new Quiz();
            tech.setName("Technology & Computing");
            tech.setCategory("technology");
            tech.setTimeLimitInSeconds(240);
            quizRepo.save(tech);

            List<Object[]> techQ = List.of(
                    new Object[] { "What does CPU stand for?", "Central Processing Unit", "Computer Personal Unit",
                            "Central Program Utility", "Core Processing Unit", "A" },
                    new Object[] { "Which company created the Java programming language?", "Microsoft", "Apple",
                            "Sun Microsystems", "IBM", "C" },
                    new Object[] { "What does HTML stand for?", "HyperText Markup Language",
                            "HighText Machine Language", "HyperText Machine Learning", "HyperText Modeling Language",
                            "A" },
                    new Object[] { "Which protocol is used for secure web browsing?", "HTTP", "FTP", "HTTPS", "SMTP",
                            "C" },
                    new Object[] { "What is the binary representation of the decimal 10?", "1000", "1010", "1100",
                            "0110", "B" },
                    new Object[] { "RAM stands for?", "Read Access Memory", "Random Access Memory",
                            "Rapid Action Memory", "Read Action Module", "B" },
                    new Object[] { "Which data structure uses LIFO?", "Queue", "Stack", "Tree", "Graph", "B" },
                    new Object[] { "What does SQL stand for?", "Structured Question Language", "Simple Query Language",
                            "Structured Query Language", "System Query Logic", "C" },
                    new Object[] { "Which of these is NOT a programming language?", "Python", "Java", "HTML", "C++",
                            "C" },
                    new Object[] { "What is the default port for HTTP?", "443", "21", "80", "8080", "C" });
            for (Object[] q : techQ) {
                Question question = new Question();
                question.setQuestionText((String) q[0]);
                question.setOptionA((String) q[1]);
                question.setOptionB((String) q[2]);
                question.setOptionC((String) q[3]);
                question.setOptionD((String) q[4]);
                question.setCorrectAnswer((String) q[5]);
                question.setQuiz(tech);
                questionRepo.save(question);
            }

            Quiz geo = new Quiz();
            geo.setName("World Geography");
            geo.setCategory("geography");
            geo.setTimeLimitInSeconds(300);
            quizRepo.save(geo);

            List<Object[]> geoQ = List.of(
                    new Object[] { "What is the capital of Australia?", "Sydney", "Melbourne", "Canberra", "Perth",
                            "C" },
                    new Object[] { "Which is the longest river in the world?", "Amazon", "Yangtze", "Mississippi",
                            "Nile", "D" },
                    new Object[] { "On which continent is the Sahara Desert?", "Asia", "Africa", "Australia",
                            "South America", "B" },
                    new Object[] { "What is the smallest country in the world?", "Monaco", "San Marino", "Vatican City",
                            "Liechtenstein", "C" },
                    new Object[] { "Which country has the most natural lakes?", "Russia", "USA", "Brazil", "Canada",
                            "D" },
                    new Object[] { "The Caspian Sea borders how many countries?", "3", "4", "5", "6", "C" },
                    new Object[] { "Mount Everest is located in which mountain range?", "Andes", "Alps", "Himalayas",
                            "Rockies", "C" },
                    new Object[] { "Which ocean is the smallest?", "Pacific", "Atlantic", "Indian", "Arctic", "D" },
                    new Object[] { "What is the capital of Japan?", "Osaka", "Kyoto", "Tokyo", "Hiroshima", "C" },
                    new Object[] { "Which country is known as the Land of the Rising Sun?", "China", "South Korea",
                            "Japan", "Vietnam", "C" });
            for (Object[] q : geoQ) {
                Question question = new Question();
                question.setQuestionText((String) q[0]);
                question.setOptionA((String) q[1]);
                question.setOptionB((String) q[2]);
                question.setOptionC((String) q[3]);
                question.setOptionD((String) q[4]);
                question.setCorrectAnswer((String) q[5]);
                question.setQuiz(geo);
                questionRepo.save(question);
            }

        }

        // ===================== ADMIN USER =====================
        User adminUser = userRepo.findByUsername(adminUsername);
        if (adminUser == null) {
            adminUser = new User();
            adminUser.setUsername(adminUsername);
            adminUser.setEmail("admin@khazar.az");
            adminUser.setFirstName("Khazar");
            adminUser.setLastName("Admin");
            adminUser.setPassword(passwordEncoder.encode(adminPassword));
            adminUser.setRole(Role.ADMIN);
            adminUser.setAge(30);
            userRepo.save(adminUser);
            System.out.println("✅ Admin user created! (Username: " + adminUsername + ")");
        }

        // ===================== BOT USERS + LEADERBOARD =====================
        String[][] bots = {
                { "khazar_pro", "bot@khazar.az", "Alex", "Storm" },
                { "deepdiver99", "bot2@khazar.az", "Maya", "Chen" },
                { "wavemind", "bot3@khazar.az", "Orion", "Blake" },
                { "caspian_ace", "bot4@khazar.az", "Sara", "Nova" },
                { "tidal_force", "bot5@khazar.az", "Zane", "Reef" },
        };

        boolean botsNeedSeeding = false;
        User[] botUsers = new User[bots.length];
        for (int i = 0; i < bots.length; i++) {
            User existing = userRepo.findByUsername(bots[i][0]);
            if (existing == null) {
                botsNeedSeeding = true;
                User bot = new User();
                bot.setUsername(bots[i][0]);
                bot.setEmail(bots[i][1]);
                bot.setFirstName(bots[i][2]);
                bot.setLastName(bots[i][3]);
                bot.setPassword(passwordEncoder.encode("bot_password_" + i));
                bot.setRole(Role.USER);
                bot.setAge(20 + i * 3);
                botUsers[i] = userRepo.save(bot);
            } else {
                botUsers[i] = existing;
            }
        }

        if (botsNeedSeeding) {
            List<Quiz> allQuizzes = quizRepo.findAll();
            if (!allQuizzes.isEmpty()) {
                int[] scores1 = { 100, 90, 80, 70, 60 };
                int[] scores2 = { 90, 100, 70, 80, 50 };
                int[] scores3 = { 80, 70, 100, 60, 90 };

                for (int i = 0; i < botUsers.length; i++) {
                    if (botUsers[i] == null)
                        continue;

                    if (allQuizzes.size() > 0) {
                        Result r1 = new Result();
                        r1.setUser(botUsers[i]);
                        r1.setQuiz(allQuizzes.get(0));
                        r1.setScore(scores1[i]);
                        r1.setCompletedAt(LocalDateTime.now().minusDays(i + 1));
                        resultRepo.save(r1);
                    }

                    if (allQuizzes.size() > 1) {
                        Result r2 = new Result();
                        r2.setUser(botUsers[i]);
                        r2.setQuiz(allQuizzes.get(1));
                        r2.setScore(scores2[i]);
                        r2.setCompletedAt(LocalDateTime.now().minusDays(i));
                        resultRepo.save(r2);
                    }

                    if (allQuizzes.size() > 2) {
                        Result r3 = new Result();
                        r3.setUser(botUsers[i]);
                        r3.setQuiz(allQuizzes.get(2));
                        r3.setScore(scores3[i]);
                        r3.setCompletedAt(LocalDateTime.now().minusHours(i * 5 + 2));
                        resultRepo.save(r3);
                    }
                }
            }
            System.out.println("✅ Bot users and scores have been seeded successfully!");
        }

        System.out.println("✅ DataSeeder finished running.");
    }
}
