package drawingshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShapeCollisionGame extends JPanel {

    // Player character size and position
    private final int playerSize = 40;
    private final int playerX = 400 - playerSize / 2; // Center of the screen (800x600)
    private final int playerY = 300 - playerSize / 2;

    // Movement offset for other shapes
    private int offsetX = 0;
    private int offsetY = 0;

    // NPC shape (rectangle body and circle head)
    private Rectangle npc = new Rectangle(600, 400, 40, 80);
    private int npcHeadSize = 20;
    private boolean npcWalking = false;

    // NPC dialogue
    private boolean showDialogue = false;
    private String dialogueMessage = "";

    // Movement speed for NPC
    private final int npcSpeed = 2;

    public ShapeCollisionGame() {
        // Set up key listener for movement and interaction
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> offsetX += 10;
                    case KeyEvent.VK_RIGHT -> offsetX -= 10;
                    case KeyEvent.VK_UP -> offsetY += 10;
                    case KeyEvent.VK_DOWN -> offsetY -= 10;
                    case KeyEvent.VK_ENTER -> interactWithNPC(); // Check for NPC interaction
                }
                repaint(); // Redraw the screen on key press
            }
        });

        // Timer to continuously update the game state
        Timer timer = new Timer(20, e -> {
            moveNPC();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw player in the center
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, playerSize, playerSize);

        // Draw the NPC (rectangle body and circle head)
        drawNPC(g);

        // Show dialogue if triggered
        if (showDialogue) {
            g.setColor(Color.BLACK);
            g.drawString(dialogueMessage, 350, 550);
        }
    }

    // Draw the NPC shape (rectangle body and circle head)
    private void drawNPC(Graphics g) {
        g.setColor(Color.ORANGE);
        // Draw the body (rectangle)
        int drawX = npc.x + offsetX;
        int drawY = npc.y + offsetY;
        g.fillRect(drawX, drawY, npc.width, npc.height);
        // Draw the head (circle)
        g.fillOval(drawX + npc.width / 4, drawY - npcHeadSize, npcHeadSize, npcHeadSize);
    }

    // Interaction logic for pressing Enter when the NPC is near
    private void interactWithNPC() {
        Rectangle playerBounds = new Rectangle(playerX, playerY, playerSize, playerSize);
        Rectangle npcBounds = new Rectangle(npc.x + offsetX, npc.y + offsetY, npc.width, npc.height);

        // Check if the player is touching the NPC
        if (playerBounds.intersects(npcBounds)) {
            showDialogue = true;
            dialogueMessage = "NPC: 'Hey there, I was looking for you!'";
        }
    }

    // Move the NPC toward the player if within a range of 3 player widths
    private void moveNPC() {
        int npcCenterX = npc.x + npc.width / 2 + offsetX;
        int npcCenterY = npc.y + npc.height / 2 + offsetY;

        int playerCenterX = playerX + playerSize / 2;
        int playerCenterY = playerY + playerSize / 2;

        // Calculate the distance between the player and NPC
        double distance = Math.sqrt(Math.pow(playerCenterX - npcCenterX, 2) + Math.pow(playerCenterY - npcCenterY, 2));

        // If the NPC is within 3 player widths, they start moving toward the player
        if (distance < playerSize * 3) {
            npcWalking = true;

            // Move the NPC horizontally toward the player
            if (npcCenterX < playerCenterX) {
                npc.x += npcSpeed;
            } else if (npcCenterX > playerCenterX) {
                npc.x -= npcSpeed;
            }

            // Move the NPC vertically toward the player
            if (npcCenterY < playerCenterY) {
                npc.y += npcSpeed;
            } else if (npcCenterY > playerCenterY) {
                npc.y -= npcSpeed;
            }
        } else {
            npcWalking = false;
        }

        // Stop the NPC when they reach the player and trigger dialogue
        if (distance < npc.width / 2 + playerSize / 2) {
            npcWalking = false;
            showDialogue = true;
            dialogueMessage = "NPC: 'Hey there, I was looking for you!'";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Collision Game with Inventory");
        ShapeCollisionGame gamePanel = new ShapeCollisionGame();
        frame.add(gamePanel);
        frame.setSize(800, 600);  // Set the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

