package com.company;

import java.util.Scanner;

public class game {

    public void play(node n, int x, int y) {
        System.out.print(" W: Up   S: Down\n" +
                "     A: Left D: Right\n");
        Scanner s = new Scanner(System.in);

            while (!winning(n.state, x, y)) {
                char r = s.next().charAt(0);
                if (r == 'a' || r == 'w' || r == 'd' || r == 's') {
                    n.state = move(r, n.state, n);
                    n.print(n.state, x, y);
                }

            }
            System.out.print("\n\n CONGRATULATIONS");
        }

    public char[][] move(char ch, char[][] s, node n) {

        if (ch == 's') {
            while (true) {
                try {
                    if (s[n.bx][n.by] == 'x') {
                        s[n.bx - 1][n.by] = 'B';
                        n.bx--;
                        break;
                    }
                } catch (Exception e) {
                    return s;
                }
                s[n.bx][n.by] = '1';
                n.bx++;
            }
        } else if (ch == 'w') {
            while (true) {
                try {
                    if (s[n.bx][n.by] == 'x') {
                        s[n.bx + 1][n.by] = 'B';
                        n.bx++;
                        break;
                    }
                } catch (Exception e) {
                    return s;
                }
                s[n.bx][n.by] = '1';
                n.bx--;
            }
        } else if (ch == 'a') {
            while (true) {
                try {
                    if (s[n.bx][n.by] == 'x') {
                        s[n.bx][n.by + 1] = 'B';
                        n.by++;
                        break;
                    }
                } catch (Exception e) {
                    return s;
                }
                s[n.bx][n.by] = '1';
                n.by--;
            }
        } else {
            while (true) {
                try {
                    if (s[n.bx][n.by] == 'x') {
                        s[n.bx][n.by - 1] = 'B';
                        n.by--;
                        break;
                    }
                } catch (Exception e) {
                    return s;
                }
                s[n.bx][n.by] = '1';
                n.by++;
            }
        }
        return s;
    }

    public boolean winning(char[][] s, int x, int y) {
        for (int i = 1; i <= x; i++)
            for (int j = 1; j <= y; j++)
                if (s[i][j] == '.') return false;
        return true;
    }
}
